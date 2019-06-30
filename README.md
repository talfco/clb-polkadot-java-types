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

## SCALE Data Format

Substrate encodes data in the "Simple Concatenated Aggregate Little-Endian" (SCALE) data format, as 
implemented by the parity-codec crate and several JavaScript modules.

It is an extremely light-weight encoding format designed for high-performance, copy-free encoding 
and decoding of data in resource-constrained execution contexts like the Substrate runtime. 

It is not self-describing in any way and assumes the decoding context has all type knowledge about 
the encoded data.

## Technical Notes

### Byte Handling
A `byte` according to the Java language spec represents a value between -128 up to 127.
The Java language doesn't provide something like a `unsigned` keyword.
If a `byte` is cast to a `int`. Java will interpret the first bit as the sign and use sign 
extension.
In order to calculate with the byte, we have to convert it into
an unsigned representation (`int`), by using the method: `Byte.toUnsignedInt(byte)`

https://stackoverflow.com/questions/4266756/can-we-make-unsigned-byte-in-java/4266841
 
# References
* https://github.com/paritytech/parity-scale-codec
* https://substrate.dev/docs/en/overview/low-level-data-format