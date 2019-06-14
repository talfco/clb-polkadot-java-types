# README:  Polkadot Type Library for Java

## Introduction

This project is in a pre-inception phase (Alpha) stay tuned - More to Come

The goal of this project is to port over the Polkadot Type Library to Java, which is 
pre-requisite if you plan to connect from a Java Application to Polkadot.

The library was built in a reverse engineer manner by assessing three exisiting
implementations:

* Parity Polkadot-JS API Library: https://github.com/polkadot-js/api/tree/master/packages/types#readme
* Polkascan Pyhton Library: https://github.com/polkascan/py-scale-codec
* Polkadot Rust Implementation

## Technical Notes

### Byte Handling
A `byte` according to the Java language spec represents a value between -128 up to 127.
The Java language doesn't provide something like a `unsigned` keyword.
If a `byte` is cast to a `int`. Java will interpret the first bit as the sign and use sign 
extension.
In order to calculate with the byte, we have to convert it into
an unsigned representation (`int`), by using the method: `Byte.toUnsignedInt(byte)`

https://stackoverflow.com/questions/4266756/can-we-make-unsigned-byte-in-java/4266841
 
