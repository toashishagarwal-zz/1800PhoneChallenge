package com.tollfree.model;

import java.util.List;

public class PhoneNumber {
	private String digits;
	private List<String> words;

	public String getDigits() {
		return digits;
	}

	public void setDigits(final String digits) {
		this.digits = digits;
	}

	public List<String> getWords() {
		return words;
	}
	
	public void setWords(final List<String> result) {
		this.words = result;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((digits == null) ? 0 : digits.hashCode());
        result = prime * result + ((words == null) ? 0 : words.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneNumber other = (PhoneNumber) obj;
        if (digits == null) {
            if (other.digits != null)
                return false;
        } else if (!digits.equals(other.digits))
            return false;
        if (words == null) {
            if (other.words != null)
                return false;
        } else if (!words.equals(other.words))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Digits: ");
        sb.append(digits);
        sb.append("\n");
        sb.append("Words : ");
        for (String s: words) {
            sb.append(s);
            sb.append("  ");
        }
        return sb.toString();
    }
}
