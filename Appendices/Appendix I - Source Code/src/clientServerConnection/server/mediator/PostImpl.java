package clientServerConnection.server.mediator;

import clientServerConnection.shared.liveFeed.LiveFeedId;
import clientServerConnection.shared.liveFeed.Post;
import clientServerConnection.shared.userStuff.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostImpl implements PostInter{
    private DBSHelper db = DBSHelper.getInstance();




//same way as bellow



    @Override
    public boolean createPost(Post post) {
        String sql = "INSERT INTO \"PoetForumV2\".posttable (poetry,genres,threadId, userId) VALUES (?,?,?,?)";
        LiveFeedId liveFeedId = new LiveFeedId(1);
        PreparedStatement userStatement = null;
        try {
            userStatement = db.getPreparedStatement(sql);

            userStatement.setString(1, post.getPost());
            userStatement.setString(2, post.getGenre());
            userStatement.setInt(3,liveFeedId.getThreadId());
            userStatement.setInt(4,1);

            return userStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}

