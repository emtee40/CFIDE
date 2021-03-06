package eu.bibl.cfide.engine.decompiler;

public class PrefixedStringBuilder {
	
	protected StringBuilder sb;
	protected String prefix;
	
	public PrefixedStringBuilder() {
		sb = new StringBuilder();
	}
	
	public PrefixedStringBuilder append(String s) {
		sb.append(s);
		if ((s != null) && s.contains("\n") && (prefix != null) && (prefix.length() > 0))// insert the prefix at every new line, overridable
			sb.append(prefix);
		return this;
	}
	
	public PrefixedStringBuilder append(Object o) {
		if (o == null) {
			sb.append("null");
			return this;
		}
		return append(o.toString());
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void trimPrefix(int amount) {
		if (prefix == null)
			return;
		if (prefix.length() < amount)
			return;
		prefix = prefix.substring(0, prefix.length() - amount);
	}
	
	public void appendPrefix(String s) {
		if (prefix == null)
			prefix = "";
		prefix += s;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	@Override
	public String toString() {
		return sb.toString();
	}
}