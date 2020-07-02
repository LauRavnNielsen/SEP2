package clientServerConnection.server.mediator;
import clientServerConnection.shared.liveFeed.LiveFeedId;
import clientServerConnection.shared.userStuff.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

    public class AccountImpl implements Account {
        private DBSHelper db = DBSHelper.getInstance();





        @Override
        public User getAccount(String userName, String password, String emailAddress, String firstName, String lastName, String dob) {
            User user = null;
            try {
                String querysql = "SELECT userName, password, emailAddress, rank, f_name, l_name, dob FROM MyPage;";
                PreparedStatement queryStudenStatement = db.getPreparedStatement(querysql);
                ResultSet resultSet = queryStudenStatement.executeQuery();
                ArrayList<Object[]> result = new ArrayList<Object[]>();


                while (resultSet.next()) {
                    Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                    for (int i = 0; i < row.length; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    result.add(row);
                }

                resultSet.close();
                queryStudenStatement.close();

                if (!result.isEmpty())
                {

                        Object[] row = result.get(0);
                        userName = row[0].toString();
                        password = row[1].toString();
                        emailAddress = row[2].toString();
                        firstName = row[3].toString();
                        lastName = row[4].toString();
                        dob = row[5].toString();


                        user = new User(userName,password,firstName,lastName,emailAddress,dob);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;
        }

        @Override
        public boolean createAccount(User user) {
            String sql = "INSERT INTO \"PoetForumV2\".mypage " +
                    "(userName,password,emailAddress,threadId,f_name, l_name, dob) " +
                    "VALUES (?,?,?,?,?,?,?)";
            LiveFeedId liveFeedId = new LiveFeedId(1);
            PreparedStatement userStatement = null;
            try {
                userStatement = db.getPreparedStatement(sql);

                userStatement.setString(1, user.getName());
                userStatement.setString(2, user.getPassword());
                userStatement.setString(3, user.getEmail());
                userStatement.setString(5, user.getFirstName());
                userStatement.setString(6, user.getLastName());
                userStatement.setString(7, user.getDob());
                userStatement.setInt(4,liveFeedId.getThreadId());
                return userStatement.executeUpdate() > 0;

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        public User getAccount(User user) {

            String userName = user.getName();
            String password = user.getPassword();
            String emailAddress = user.getEmail();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String dob = user.getDob();
            try {
                String querysql = "SELECT userName, password, emailAddress, f_name, l_name, dob FROM \"PoetForumV2\".MyPage WHERE userName = '" + user.getName() + "';";
                LiveFeedId liveFeedId = new LiveFeedId(1);
                PreparedStatement queryStudenStatement = db.getPreparedStatement(querysql);
                ResultSet resultSet = queryStudenStatement.executeQuery();
                ArrayList<Object[]> result = new ArrayList<Object[]>();


                while (resultSet.next()) {
                    Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                    for (int i = 0; i < row.length; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    result.add(row);
                }

                resultSet.close();
                queryStudenStatement.close();

                if (!result.isEmpty())
                {

                    Object[] row = result.get(0);
                    userName = row[0].toString();
                    password = row[1].toString();
                    emailAddress = row[4].toString();
                    firstName = row[2].toString();
                    lastName = row[3].toString();
                    dob = row[5].toString();


                    user = new User(userName,password,firstName,lastName,emailAddress,dob);

                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return user;

        }
        @Override
        public User getAccountByPasswordAndName(String password, String userName) {

            User user = null;
            //SQL statement
            String query = "SELECT * from \"PoetForumV2\".myPage where username = '" + userName + "' and password = '" + password + "';";

            try {
                PreparedStatement queryStudenStatement = db.getPreparedStatement(query);
                ResultSet resultSet = queryStudenStatement.executeQuery();
                ArrayList<Object[]> result = new ArrayList<Object[]>();

                while (resultSet.next()) {
                    Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                    for (int i = 0; i < row.length; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    result.add(row);
                }



                resultSet.close();
                queryStudenStatement.close();

                if (!result.isEmpty())
                {

                    Object[] row = result.get(0);
                    userName = row[0].toString();
                    password = row[1].toString();
//                   emailAddress = row[2].toString();
//                    firstName = row[3].toString();
//                    lastName = row[4].toString();
//                    dob = row[5].toString();


                    //user = new User(userName,password,firstName,lastName,emailAddress,dob);
                    user = new User();
                    user.setName(userName);
                    user.setPassword(password);


                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
        }

        @Override
        public User getAccountByUserName(String userName) {
            User user = null;

            String password = user.getPassword();
            String emailAddress = user.getEmail();
            String firstName = user.getFirstName();
            String lastName = user.getLastName();
            String dob = user.getDob();

            //SQL statement
            String query = "SELECT * from \"PoetForumV2\".myPage where username = '" + userName + "';";

            try {
                PreparedStatement queryStudenStatement = db.getPreparedStatement(query);
                ResultSet resultSet = queryStudenStatement.executeQuery();
                ArrayList<Object[]> result = new ArrayList<Object[]>();

                while (resultSet.next()) {
                    Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                    for (int i = 0; i < row.length; i++) {
                        row[i] = resultSet.getObject(i + 1);
                    }
                    result.add(row);
                }

                resultSet.close();
                queryStudenStatement.close();

                if (!result.isEmpty())
                {

                    Object[] row = result.get(0);
                    userName = row[0].toString();
                    password = row[1].toString();
                    emailAddress = row[2].toString();
                    firstName = row[3].toString();
                    lastName = row[4].toString();
                    dob = row[5].toString();


                    user = new User(userName,password,firstName,lastName,emailAddress,dob);



                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return user;
        }




    }