# README:  Parity Codec Library for Java

## Introduction

This project is in a pre-inception phase (Alpha) stay tuned - More to Come

The goal of this project is to port over to the Phyton Codec Library by Polkascan to Java

* https://github.com/polkascan/py-scale-codec
* https://www.npmjs.com/package/@polkadot/types

## Byte Handling
A `byte` according to the Java language spec represents a value between -128 up to 127.
The Java language doesn't provide something like a `unsigned` keyword.
If a `byte` is cast to a `int`. Java will interpret the first bit as the sign and use sign 
extension.
In order to calculate with the byte, we have to convert it into
an unsigned representation (`int`), by using the method: `Byte.toUnsignedInt(byte)`

https://stackoverflow.com/questions/4266756/can-we-make-unsigned-byte-in-java/4266841
 
