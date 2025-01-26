package no.hvl.data102.filmarkiv.impl;

public class LinearNode<T> {
	public T data;
	public LinearNode<T> neste;
	
	public LinearNode() {
		data = null;
		neste = null;
    }
	
	public LinearNode(T data) {
        this.data = data;
        this.neste = null;
    }
	
	public void addData(T data) {
		LinearNode<T> nyNode = new LinearNode<>(data);
		
		if(this.neste != null)
			nyNode.neste = this.neste;
		
		this.neste = nyNode;
	}
	
	public boolean fjernNeste() {
		if(this.neste == null)
			return false;
		this.neste = this.neste.neste;
		return true;
	}
}










