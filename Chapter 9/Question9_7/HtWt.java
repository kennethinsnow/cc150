package Question9_7;

public class HtWt implements Comparable<Object> {
	private int Ht;
	private int Wt;
	private HtWt	pre = null;
	public HtWt(int h, int w) { Ht = h; Wt = w;}
	
	public int compareTo( Object s ) {
		HtWt second = (HtWt) s;
		if (this.Ht != second.Ht) { 
			return ((Integer)this.Ht).compareTo(second.Ht);
		} else {
			return ((Integer)this.Wt).compareTo(second.Wt);
		}
	}
	
	public String toString() {
		return "(" + Ht + ", " + Wt + ")";
	}
	
	public String printForward(){
		HtWt curPre = this.pre;
		StringBuffer sb = new StringBuffer();
		sb.append("(" + Ht + ", " + Wt + ")");
		while (curPre != null){
			sb.append(" -> " + curPre.toString());
			curPre = curPre.getPre();
		}
		return sb.toString();
	}
	
	public boolean isBefore(HtWt other) {
		if (this.Ht < other.Ht && this.Wt < other.Wt) {
			return true;
		} else {
			return false;
		}
	}

	public HtWt getPre() {
		return pre;
	}

	public void setPre(HtWt pre) {
		this.pre = pre;
	}
}
