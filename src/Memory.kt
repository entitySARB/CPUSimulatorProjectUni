object Memory {
    private val words = inputParser(Storage.instructions)
    init {
        for (i in words.size ..< Config.MEMORY_SIZE.toInt()) words.add(0u)
        if (words.size.toUInt() > Config.MEMORY_SIZE) {
            throw RuntimeException("Program cannot fit into memory")
        }
    }

    fun read(): UInt {
        return words[CPUSimulator.MAR.toInt()]
    }

    fun write(value: UInt) {
        words[CPUSimulator.MAR.toInt()] = value
    }
}