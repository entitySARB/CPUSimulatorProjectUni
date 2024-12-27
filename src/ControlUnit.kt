object ControlUnit {
    const val log = true
    private var T = 0u
    fun clock() {
        if (CPUSimulator.HALT) return
        when (T) {
            0u -> {
                CPUSimulator.readPC()
                CPUSimulator.writeMAR()
                CPUSimulator.incrementPC()
                incrementT()
            }
            1u -> {
                CPUSimulator.readMemory()
                CPUSimulator.writeIR()
                incrementT()
            }
            2u -> {
                when (CPUSimulator.IR shr 24) {
                    0b100u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        ALU.ADD()
                        resetT()
                    }
                    0b101u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        ALU.SUB()
                        resetT()
                    }
                    0b110u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        ALU.MPY()
                        resetT()
                    }
                    0b10u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writePC()
                        resetT()
                    }
                    0b11u -> {
                        if (ALU.IFM()) {
                            CPUSimulator.readIR()
                            CPUSimulator.writePC()
                        }
                        resetT()
                    }
                    0b1000u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        incrementT()
                    }
                    0b1001u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        incrementT()
                    }
                    0b1100u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        incrementT()
                    }
                    0b1101u -> {
                        CPUSimulator.readIR()
                        CPUSimulator.writeMAR()
                        incrementT()
                    }
                    0b1111u -> {
                        CPUSimulator.setHALT()
                        CPUSimulator.emptyBUS()
                        CPUSimulator.resetAC()
                        CPUSimulator.resetMAR()
                        CPUSimulator.resetPC()
                        CPUSimulator.resetIR()
                        resetT()
                    }
                    else -> resetT()
                }
            }
            3u -> {
                when (CPUSimulator.IR shr 24) {
                    0b1000u -> {
                        CPUSimulator.readAC()
                        CPUSimulator.writeMemory()
                        resetT()
                    }
                    0b1001u -> {
                        CPUSimulator.readMemory()
                        CPUSimulator.writeAC()
                        resetT()
                    }
                    0b1100u -> {
                        CPUSimulator.readIN()
                        CPUSimulator.writeMemory()
                        resetT()
                    }
                    0b1101u -> {
                        CPUSimulator.readMemory()
                        CPUSimulator.writeOUT()
                        resetT()
                    }
                    else -> resetT()
                }
            }
            else -> resetT()
        }
    }

    private fun incrementT() {
        log()
        T++
    }

    private fun resetT() {
        log()
        T = 0u
    }

    private fun log() {
        if (!log) return
        if (T == 0u) {
            println()
            println("INSTRUCTION ${CPUSimulator.PC} | ${Storage.instructions[CPUSimulator.PC.toInt()-1].substringBefore(";")}")
        }
        println("T$T"
                + " | IR: ${"0".repeat((32 - CPUSimulator.IR.toString(2).length))+CPUSimulator.IR.toString(2)}"
                + " | PC: ${"0".repeat((32 - CPUSimulator.PC.toString(2).length))+CPUSimulator.PC.toString(2)}"
                + " | MAR: ${"0".repeat((32 - CPUSimulator.MAR.toString(2).length))+CPUSimulator.MAR.toString(2)}"
                + " | AC: ${"0".repeat((32 - CPUSimulator.AC.toString(2).length))+CPUSimulator.AC.toString(2)}"
        )
    }
}