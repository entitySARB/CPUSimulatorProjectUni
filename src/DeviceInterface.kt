object DeviceInterface {
    var readFlag = false
    var writeFlag = false
    fun input(): UInt {
        readFlag = true
        writeFlag = false
        print("INPUT: ")
        return readln().toUInt(2)
    }
    fun output(bus: UInt) {
        writeFlag = true
        readFlag = false
        println("OUTPUT: ${bus.toString(2)}")
    }
}