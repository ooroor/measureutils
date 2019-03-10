package net.barakiroth.measureutils.length;

import lombok.AccessLevel;
import lombok.Getter;

public class Inch extends AbstractLength<Inch> {
	
	@Getter(AccessLevel.PRIVATE)
	private final static LengthUnit LENGTH_UNIT = LengthUnit.INCH;
	
	private Inch(final double size) {
		super(size, getLENGTH_UNIT());
	}

	public static Inch of(final double size) {
		return new Inch(size);
	}

	public static Inch copyOf(final AbstractLength<?> otherLength) {
		return Inch.of(otherLength.getCanonicalSize() / getLENGTH_UNIT().getUnitSizeInCanonicalLength());
	}

	private static Inch ofCanonicalSize(final double canonicalSize) {
		return Inch.of(canonicalSize/getLENGTH_UNIT().getUnitSizeInCanonicalLength());
	}
	
	@Override	
	protected Inch ofCanonicalSizeInternal(final double canonicalSize) {
		return Inch.ofCanonicalSize(canonicalSize);
	}
}
