object CPUSimulator {
    var HALT = true
    var AC = 0u
    var PC = 0u
    var IR = 0u
        private set
    var MAR = 0u
        private set
    private val IN get() = DeviceInterface.input()
    private var OUT = 0u
        set(value) {
            DeviceInterface.output(value)
            field = value
        }
    private var BUS = 0u
        get() {
            val temp = field
            field = 0u
            return temp
        }

    fun setHALT() {
        HALT = true
    }

    fun unsetHALT() {
        HALT = false
    }

    fun readIR() {
        BUS = IR and 0b11111111_11111111_11111111u
    }

    fun writeIR() {
        IR = BUS
    }

    fun readPC() {
        BUS = PC
    }

    fun writePC() {
        PC = BUS
    }

    fun incrementPC() {
        PC++
    }

    fun readIN() {
        BUS = IN
    }

    fun writeOUT() {
        OUT = BUS
    }

    fun readAC() {
        BUS = AC
    }

    fun writeAC() {
        AC = BUS
    }

    fun readMemory() {
        BUS = Memory.read()
    }

    fun writeMemory() {
        Memory.write(BUS)
    }

    fun readMAR() {
        BUS = MAR
    }

    fun writeMAR() {
        MAR = BUS
    }

    fun resetAC() {
        AC = 0u
    }

    fun resetPC() {
        PC = 0u
    }

    fun resetIR() {
        IR = 0u
    }

    fun resetMAR() {
        MAR = 0u
    }

    fun emptyBUS() {
        BUS = 0u
    }
}