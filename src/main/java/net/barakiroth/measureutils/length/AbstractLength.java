package net.barakiroth.measureutils.length;

import lombok.AccessLevel;
import lombok.Getter;

public abstract class AbstractLength<LENGTH_TYPE extends AbstractLength<LENGTH_TYPE>> {

	@Getter(AccessLevel.PUBLIC)
	private final double size;

	@Getter(AccessLevel.PUBLIC)
	private final LengthUnit lengthUnit;

	protected AbstractLength(
			final double     size,
			final LengthUnit lengthUnit) {

		this.size = size;
		this.lengthUnit = lengthUnit;
	}
	
	public double getCanonicalSize() {
		final double canonicalSize =
				getSize() * getLengthUnit().getUnitSizeInCanonicalLength();
		return canonicalSize;		
	}
	
	protected LENGTH_TYPE plus(final AbstractLength<?> otherLength) {
		final double thisCanonicalSize = this.getCanonicalSize();
		final double otherCanonicalSize = otherLength.getCanonicalSize();
		final double sumCanonicalSize = thisCanonicalSize + otherCanonicalSize;
		
		final LENGTH_TYPE sum = this.ofCanonicalSizeInternal(sumCanonicalSize);
		
		return sum;
	}
	
	protected abstract LENGTH_TYPE ofCanonicalSizeInternal(final double canonicalSize);
}