package clientServerConnection.server.mediator;

import clientServerConnection.shared.liveFeed.Post;

public interface PostInter {


//    Post getPost(String poetry, String genres, String userName);
//    boolean createPostByPoetryGenreThreadId(String poetry, String genres, int threadId);
    boolean createPost(Post post);



}
