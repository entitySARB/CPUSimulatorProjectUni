# CPU Simulator

A CPU simulator for my university project  
This is a 32-bit CPU, and it can be easy modified to add new features

## Description
First the instructions are read from the file in Storage  
After that each instruction is parsed by InputParsed and turn into corresponding machine code  
Which than the cpu simulation start by running clock in a while with a delay (Clock is defined in ControlUnit)  
In each clock corresponding cpu signal are called (Signals are functions in CPUSimulator)  
Register value can be processed by ALU or stored and loaded by Memory
Also DeviceInterface works as a device which either outputs or give cpu input from console on request
Additional config for cpu are in Config object

## Usage/Examples

A factorial function is already available in instructions.txt  
The instructions are describe here
```
<Assmebely Code> <7-Length number>
ADD0000000; Add the value at memory location 0 to the accumulator
SUB0000000; Subtract the value at memory location 0 from the accumulator
MPY0000000; Multiply the accumulator by the value at memory location 0
BRU0000000; Unconditional branch to instruction 0
BRM0000000; Branch to instruction 0 if the accumulator is negative
STO0000000; Store the accumulator value into memory location 0
LDA0000000; Load the value at memory location 0 into the accumulator
RWD0000000; Read a word from the device into memory location 0
WWD0000000; Write a word from memory location 0 to the device
HLT0000000; Halt CPU

Each of these assmebely codes translate to its corresponding CPU machine code
00000000 (INSTRUCTION) 00000000_00000000_00000000 (VALUE)
00000100 ADD
00000101 SUB
00000110 MPY
00000010 BRU
00000011 BRM
00001000 STO
00001001 LDA
00001100 RWD
00001101 WWD
00001111 HLT
```


## License

[MIT](https://choosealicense.com/licenses/mit/)

