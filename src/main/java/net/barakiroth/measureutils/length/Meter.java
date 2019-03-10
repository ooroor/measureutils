package net.barakiroth.measureutils.length;

import lombok.AccessLevel;
import lombok.Getter;

public class Meter extends AbstractLength<Meter> {

	@Getter(AccessLevel.PRIVATE)
	private final static LengthUnit LENGTH_UNIT = LengthUnit.METER;
	
	private Meter(final double size) {
		super(size, getLENGTH_UNIT());
	}

	public static Meter of(final double size) {
		return new Meter(size);
	}

	public static Meter copyOf(final AbstractLength<?> otherLength) {
		return Meter.of(otherLength.getCanonicalSize() / getLENGTH_UNIT().getUnitSizeInCanonicalLength());
	}

	private static Meter ofCanonicalSize(final double canonicalSize) {
		return Meter.of(canonicalSize/getLENGTH_UNIT().getUnitSizeInCanonicalLength());
	}
	
	@Override	
	protected Meter ofCanonicalSizeInternal(final double canonicalSize) {
		return Meter.ofCanonicalSize(canonicalSize);
	}
}
