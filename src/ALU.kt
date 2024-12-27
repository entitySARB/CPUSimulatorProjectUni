object ALU {
    fun ADD() {
        CPUSimulator.AC += Memory.read()
    }

    fun SUB() {
        CPUSimulator.AC -= Memory.read()
    }

    fun MPY() {
        CPUSimulator.AC *= Memory.read()
    }

    fun IFM(): Boolean {
        return CPUSimulator.AC shr 31 == 1u
    }
}
