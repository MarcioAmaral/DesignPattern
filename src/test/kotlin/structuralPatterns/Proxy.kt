package structuralPatterns

import org.junit.jupiter.api.Test

interface Image {
    fun display()
}

class RealImage(private val filename: String): Image {
    override fun display() {
        println("RealImage: Display $filename")
    }

    private fun loadFromDisk(filename: String) {
        println("RealImage: loading $filename")
    }

    init {
        loadFromDisk(filename)
    }
}

class ProxyImage(private val filename: String): Image {
    private var realImage: RealImage? = null

    override fun display() {
        println("ProxyImage: Display $filename")
        if (realImage == null) {
            realImage = RealImage(filename)
        }
        realImage!!.display()
    }
}

class ProxyTest {
    @Test
    fun testProxy() {
        val image = ProxyImage("test.jpg")

        // load image from disk
        image.display()
        println("-------------------------------")

        //load image form "cache"
        image.display()
    }
}