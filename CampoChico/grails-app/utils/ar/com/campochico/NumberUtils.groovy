package ar.com.campochico

import java.text.DecimalFormat;

class NumberUtils {

	/**
	 * Da formato a una cantidad usando decimales en forma apropiada:
	 * 1.0 -> 1
	 * 1.3 -> 1.3
	 * 1.34 -> 1.34
	 * @param quantity
	 * @return
	 */
	public static String formatQuantity(Double quantity) {
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);
		return df.format(quantity);
	}
	
	public static String formatCurrency(Double currency) {
		DecimalFormat df = new DecimalFormat("\$#.##");
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(0);
		df.setGroupingUsed(false);
		return df.format(currency);
	}
}
