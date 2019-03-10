#  measuringunitsutils

Library for easy conversion between and arithmetics on measuring units.
## Conversion:
`````
final Inch  oneInch = Inch.of(1.0);
final Meter someMeters = Meter.copyOf(oneInch);
final double sizeOfSomeMeters = someMeters.getSize();
`````
## Addition:
`````
final double size1 = 1.0;
final double size2 = 1.0;
final Inch oneInch = Inch.of(size1);
final Meter oneMeter = Meter.of(size2);
final Meter sumMeter = oneMeter.plus(oneInch);
`````
The same scenario goes for units being the same.