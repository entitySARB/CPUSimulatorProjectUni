fun inputParser(instructions: MutableList<String>): MutableList<UInt> {
    val instructionsOfCPU = mutableListOf<UInt>()
    for (i in instructions) {
        var instruction = 0u
        val offset = if (i.startsWith("+")) 1 else 0
        val keyword = i.substring(0 + offset, 3 + offset)
        val value = i.substringBefore(";").substring(3 + offset).toUInt()

        if ((keyword.toLongOrNull() ?: -1) != -1L) {
            instruction = i.substring(0 + offset, 10 + offset).toUInt()
        } else {
            instruction += when (keyword) {
                "ADD" -> (0b100 shl 24).toUInt()
                "SUB" -> (0b101 shl 24).toUInt()
                "MPY" -> (0b110 shl 24).toUInt()
                "BRU" -> (0b10 shl 24).toUInt()
                "BRM" -> (0b11 shl 24).toUInt()
                "STO" -> (0b1000 shl 24).toUInt()
                "LDA" -> (0b1001 shl 24).toUInt()
                "RWD" -> (0b1100 shl 24).toUInt()
                "WWD" -> (0b1101 shl 24).toUInt()
                "HLT" -> (0b1111 shl 24).toUInt()
                else -> throw RuntimeException("Invalid Instruction: $keyword")
            } + value
        }

        instructionsOfCPU.add(instruction)
    }
    return instructionsOfCPU
}