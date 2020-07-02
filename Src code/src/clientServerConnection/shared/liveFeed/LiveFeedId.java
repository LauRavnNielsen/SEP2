package clientServerConnection.shared.liveFeed;

import java.io.Serializable;

public class LiveFeedId implements Serializable {
    private int threadId;

    public LiveFeedId(int threadId){
        this.threadId = threadId;
    }
    public void setThreadId(int threadId){
        this.threadId = threadId;
    }
    public int getThreadId(){
        return 1;
    }
}
