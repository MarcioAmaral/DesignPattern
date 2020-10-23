package structuralPatterns

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

interface Device {
    var volume: Int
    fun getName(): String
}

class Radio: Device {
    override var volume = 0
    override fun getName() = "Radio $this"
}

class Tv : Device {
    override var volume = 0
    override fun getName() = "Tv $this"
}

interface Remote {
    fun volumeUp()
    fun volumeDown()
}

class BasicRemote(val device: Device): Remote {
    override fun volumeUp() {
        device.volume++
        println("${device.getName()} volume up: ${device.volume}")
    }

    override fun volumeDown() {
        device.volume--
        println("${device.getName()} volume down: ${device.volume}")
    }
}

class BridgeTest {
    @Test
    fun TestBridge() {
        val radio = Radio()
        val radioRemote = BasicRemote(radio)
        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeUp()
        radioRemote.volumeDown()

        val tv = Tv()
        val tvRemote = BasicRemote(tv)
        tvRemote.volumeUp()
        tvRemote.volumeDown()

        Assertions.assertThat(tvRemote.device.volume).isEqualTo(0)
        Assertions.assertThat(radioRemote.device.volume).isEqualTo(2)
    }
}