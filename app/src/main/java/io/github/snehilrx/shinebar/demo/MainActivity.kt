package io.github.snehilrx.shinebar.demo

import android.graphics.Color.rgb
import android.os.Bundle
import android.widget.MediaController
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.snehil.shinebar.demo.R
import com.snehil.shinebar.demo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.recycler.apply {
            adapter = GradientAdapter(colorList, this@MainActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.shinebar.apply {
                        setStartColor(colorList[position].first)
                        setEndColor(colorList[position].second)
                    }
                }
            })
        }
        val mediaController = MediaController(this)
        binding.videoView.setMediaController(mediaController)
        binding.videoView.setVideoPath("android.resource://$packageName/${R.raw.sample}")
        binding.videoView.start()
        binding.videoView.setOnPreparedListener { mp -> mp.isLooping = true; }
        colorList[0].let {
            binding.shinebar.apply {
                setStartColor(it.first)
                setEndColor(it.second)
            }
        }
        binding.shinebar.makeAppbarImmersive(this, binding.root)
    }

    companion object {
        @JvmStatic
        val colorList: List<Pair<Int, Int>> = arrayListOf(
        Pair(rgb(55, 59, 68), rgb(66, 134, 244)),
        Pair(rgb(255, 0, 153), rgb(73, 50, 64)),
        Pair(rgb(142, 45, 226), rgb(74, 0, 224)),
        Pair(rgb(195, 20, 50), rgb(36, 11, 54)),
        Pair(rgb(0, 159, 255), rgb(236, 47, 75)),
        Pair(rgb(237, 33, 58), rgb(147, 41, 30)),
        Pair(rgb(0, 180, 219), rgb(0, 131, 176)),
        Pair(rgb(99, 99, 99), rgb(162, 171, 88)),
        Pair(rgb(173, 83, 137), rgb(60, 16, 83)),
        Pair(rgb(51, 51, 51), rgb(221, 24, 24)),
        Pair(rgb(188, 78, 156), rgb(248, 7, 89)),
        Pair(rgb(201, 75, 75), rgb(75, 19, 79)),
        Pair(rgb(35, 7, 77), rgb(204, 83, 51)),
        Pair(rgb(60, 59, 63), rgb(96, 92, 60)),
        Pair(rgb(0, 242, 96), rgb(5, 117, 230)),
        Pair(rgb(127, 0, 255), rgb(225, 0, 255)),
        Pair(rgb(0, 0, 0), rgb(15, 155, 15)),
        Pair(rgb(40, 60, 134), rgb(69, 162, 71)),
        Pair(rgb(21, 153, 87), rgb(21, 87, 153)),
        Pair(rgb(0, 0, 70), rgb(28, 181, 224)),
        Pair(rgb(235, 87, 87), rgb(0, 0, 0)),
        Pair(rgb(32, 0, 44), rgb(203, 180, 212)),
        Pair(rgb(52, 232, 158), rgb(15, 52, 67)),
        Pair(rgb(68, 160, 141), rgb(9, 54, 55)),
        Pair(rgb(32, 1, 34), rgb(111, 0, 0)),
        Pair(rgb(5, 117, 230), rgb(2, 27, 121)),
        Pair(rgb(67, 198, 172), rgb(25, 22, 84)),
        Pair(rgb(9, 48, 40), rgb(35, 122, 87)),
        Pair(rgb(240, 242, 240), rgb(0, 12, 64)),
        Pair(rgb(238, 9, 121), rgb(255, 106, 0)),
        Pair(rgb(65, 41, 90), rgb(47, 7, 67)),
        Pair(rgb(255, 0, 204), rgb(51, 51, 153)),
        Pair(rgb(222, 97, 97), rgb(38, 87, 235)),
        Pair(rgb(58, 97, 134), rgb(137, 37, 62)),
        Pair(rgb(248, 80, 50), rgb(231, 56, 39)),
        Pair(rgb(203, 45, 62), rgb(239, 71, 58)),
        Pair(rgb(0, 4, 40), rgb(0, 78, 146)),
        Pair(rgb(66, 39, 90), rgb(115, 75, 109)),
        Pair(rgb(20, 30, 48), rgb(36, 59, 85)),
        Pair(rgb(240, 0, 0), rgb(220, 40, 30)),
        Pair(rgb(44, 62, 80), rgb(76, 161, 175)),
        Pair(rgb(11, 72, 107), rgb(245, 98, 23)),
        Pair(rgb(29, 67, 80), rgb(164, 57, 49)),
        Pair(rgb(168, 0, 119), rgb(102, 255, 0)),
        Pair(rgb(0, 0, 0), rgb(67, 67, 67)),
        Pair(rgb(75, 121, 161), rgb(40, 62, 81)),
        Pair(rgb(0, 153, 247), rgb(241, 23, 18)),
        Pair(rgb(41, 128, 185), rgb(44, 62, 80)),
        Pair(rgb(90, 63, 55), rgb(44, 119, 68)),
        Pair(rgb(47, 115, 54), rgb(170, 58, 56)),
        Pair(rgb(30, 60, 114), rgb(42, 82, 152)),
        Pair(rgb(64, 58, 62), rgb(190, 88, 105)),
        Pair(rgb(142, 14, 0), rgb(31, 28, 24)),
        Pair(rgb(0, 92, 151), rgb(54, 55, 149)),
        Pair(rgb(229, 57, 53), rgb(227, 93, 91)),
        Pair(rgb(252, 0, 255), rgb(0, 219, 222)),
        Pair(rgb(44, 62, 80), rgb(52, 152, 219)),
        Pair(rgb(186, 139, 2), rgb(24, 24, 24)),
        Pair(rgb(82, 82, 82), rgb(61, 114, 180)),
        Pair(rgb(0, 79, 249), rgb(255, 249, 76)),
        Pair(rgb(106, 145, 19), rgb(20, 21, 23)),
        Pair(rgb(0, 191, 143), rgb(0, 21, 16)),
        Pair(rgb(255, 0, 132), rgb(51, 0, 27)),
        Pair(rgb(100, 65, 165), rgb(42, 8, 69)),
        Pair(rgb(255, 161, 127), rgb(0, 34, 62)),
        Pair(rgb(54, 0, 51), rgb(11, 135, 147)),
        Pair(rgb(72, 85, 99), rgb(41, 50, 60)),
        Pair(rgb(82, 194, 52), rgb(6, 23, 0)),
        Pair(rgb(254, 140, 0), rgb(248, 54, 0)),
        Pair(rgb(0, 198, 255), rgb(0, 114, 255)),
        Pair(rgb(120, 2, 6), rgb(6, 17, 97)),
        Pair(rgb(0, 0, 0), rgb(231, 76, 60)),
        Pair(rgb(135, 0, 0), rgb(25, 10, 5)),
        Pair(rgb(33, 95, 0), rgb(228, 228, 217)),
        Pair(rgb(194, 21, 0), rgb(255, 197, 0)),
        Pair(rgb(233, 211, 98), rgb(51, 51, 51)),
        Pair(rgb(167, 55, 55), rgb(122, 40, 40)),
        Pair(rgb(75, 108, 183), rgb(24, 40, 72)),
        Pair(rgb(65, 77, 11), rgb(114, 122, 23)),
        Pair(rgb(228, 58, 21), rgb(230, 82, 69)),
        Pair(rgb(192, 72, 72), rgb(72, 0, 72)),
        Pair(rgb(220, 36, 36), rgb(74, 86, 157)),
        Pair(rgb(35, 37, 38), rgb(65, 67, 69)),
        Pair(rgb(97, 67, 133), rgb(81, 99, 149)),
        Pair(rgb(22, 34, 42), rgb(58, 96, 115)),
        Pair(rgb(235, 51, 73), rgb(244, 92, 67)),
        Pair(rgb(170, 7, 107), rgb(97, 4, 95)),
        Pair(rgb(2, 170, 176), rgb(0, 205, 172)),
        Pair(rgb(211, 16, 39), rgb(234, 56, 77)),
        Pair(rgb(229, 45, 39), rgb(179, 18, 23)),
        Pair(rgb(49, 71, 85), rgb(38, 160, 218)),
        Pair(rgb(43, 88, 118), rgb(78, 67, 118)),
        Pair(rgb(230, 92, 0), rgb(249, 212, 35)),
        Pair(rgb(83, 105, 118), rgb(41, 46, 73)))
    }
}