fun main() {
    CPUSimulator.unsetHALT()
    while (!CPUSimulator.HALT) {
        ControlUnit.clock()
        Thread.sleep(10)
    }
}