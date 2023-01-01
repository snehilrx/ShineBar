#version 300 es

#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif

const float _zero = float(0);
const float _one = float(1);
const float _two = float(2);
const float _half = float(0.5);
const float _quater = float(0.25);
const float _pi = float(3.14159265359);

uniform vec2 uViewSize;
uniform vec4 uStartColor;
uniform vec4 uEndColor;
uniform float uMarginTop;
uniform float uDistanceY;
uniform float uTotalScroll;

out vec4 fragColor;

// Define the Bezier curve as a function B(t)
// where t is a value between 0 and 1
// and the control points are A, B, and C
vec2 curve(float t, vec2 A, vec2 B, vec2 C) {
    return (_one - t) * (_one - t) * A + _two * (_one - t) * t * B + t * t * C;
}

// Find the projection of point P onto the Bezier curve
// by finding the value of t that minimizes the distance
// between P and B(t)
// Newton - Raphson
float projection(vec2 P, vec2 A, vec2 B, vec2 C) {
    // Initialize t to a value between 0 and 1
    float t = 0.5;

    const float eps = 1.0;
    for (int i = 0; i<8; i++) {
        // Calculate the value of B(t) and its derivative
        vec2 Bt = curve(t, A, B, C);
        vec2 dBt = _two * (_one - t) * B + _two * t * C;

        // Check if the current value of t is close enough to the
        // minimum distance. If so, stop the iteration.
        if (length(Bt - P) < eps) break;

        // Update the value of t using the Newton-Raphson method
        t = t - dot(Bt - P, dBt) / dot(dBt, dBt);
    }

    return t;
}

void main(){
    float progress = uDistanceY/uTotalScroll;
    float extra = ((uViewSize.y - uTotalScroll - uMarginTop) * progress);

    // the gradient begins with a point as origin and as the progress increases
    // the origin changes to a line whose max length will be half of the view width
    float length = uViewSize.x * progress * _half;


    // control points of Bezier curve
    vec2 A = vec2(_zero, extra + uDistanceY - (uMarginTop * progress));
    vec2 B = vec2(length, uViewSize.y   - uMarginTop);
    vec2 C = vec2(uViewSize.x, uViewSize.y - _two * uMarginTop);

    // making sure point c never crosses point a
    if (C.y < A.y) {
        C.y = A.y;
    }

    vec2 P = gl_FragCoord.xy;

    float t = projection(P, A, B, C);

    // projection point on the curve
    vec2 Bt = curve(t, A, B, C);

    // starting and ending point of the origin line
    float start_x = length - length;
    float end_x = length + length;

    // picking a point on the origin line which is  to the point p
    if (P.x > start_x && P.x < end_x) {
        start_x = P.x;
    } else if (P.x >= end_x) {
        start_x = end_x;
    }

    vec2 origin = vec2(start_x,  uViewSize.y);
    if ((P-origin).x <= (Bt-origin).x && (P-origin).y >= (Bt-origin).y) {
        float distance_ratio = _one - length(P - origin) / length(Bt - origin);
        vec3 color = mix(uStartColor.rgb, uEndColor.rgb, distance_ratio);
        fragColor = vec4(color.rgb, distance_ratio);
    }
}