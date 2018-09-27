package com.comcast.sumproject.service;

import java.io.IOException;

public interface SumService {

	public long getDigitsSum(String str);

	public long getDigitsSumFromFile(String fileName) throws IOException;

	public long getHexDigitsSum(String str);

}
