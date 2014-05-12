package org.gradle;

public class JsonOutput {
	
	 	private final long id;
	    private final String content;

	    public JsonOutput(long id, String content) {
	        this.id = id;
	        this.content = content;
	    }

	    public long getId() {
	        return id;
	    }

	    public String getContent() {
	        return content;
	    }
}
