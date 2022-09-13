package io.github.quoteapp.utils

import android.graphics.Color
import androidx.core.graphics.ColorUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.random.Random

val colorList = mutableListOf<MyColor>()

suspend fun coler(size:Int?):List<MyColor>{
    withContext(Dispatchers.Main){
        var randomBlue: Int
        var randomRed: Int
        var randomGreen: Int
        var compRed: Int
        var compGreen: Int
        var compBlue: Int
        var randomColor: Int
        var randomComplementColors: Int

        if (size != null) {
            repeat(size){
                do {
                    randomBlue = Random.nextInt(0, 255)
                    randomRed = Random.nextInt(0, 255)
                    randomGreen = Random.nextInt(0, 255)
                    compRed = 255 - randomRed
                    compGreen = 255 - randomGreen
                    compBlue = 255 - randomBlue
                    randomColor = Color.argb(255, randomRed, randomGreen, randomBlue)
                    randomComplementColors = Color.argb(255, compRed, compGreen, compBlue)


                } while (ColorUtils.calculateContrast(
                        randomColor,
                        randomComplementColors
                    ) < 5
                )
                colorList.add(MyColor(randomColor, randomComplementColors))

            }
        }



    }
    return colorList
}

data class MyColor(val forGroundColor: Int, val backGroundColor: Int)