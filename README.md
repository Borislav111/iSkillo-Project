# iSkillo-Project

The project consists of automated test cases on the website "http://training.skillo-bg.com/posts/all". It follows the Page Object Model pattern and Page Factory.
It contains eight different test scenarios, with each page of the tested website in a separate class.
The goal of this automated testing is to verify that the website's functionality meets the predefined specifications.

The project includes the following tests:

1. CommentPostNonReg "Comment a post as a guest"
This test verifies whether an unregistered user can post a comment on a published post. According to the requirements, 
an unregistered user cannot publish comments under the posts on the website. The test passes because the system behaves as expected.

2. DislikePost "Dislike a post without logging in"
This test checks whether an unregistered user can dislike a post. During testing, a bug is discovered because according to the specifications,
an unregistered user cannot comment/like/dislike posts.

3. FollowUser "Follow the first user from the homepage"
The goal of this test is for the user to enter the system with the correct credentials and follow the last user who has posted on the homepage.
If the user has already been followed, the test will fail because the goal is only to follow the specified user.

4. InvalidLoginTest "Use of different ways to log in with invalid credentials"
Invalid data is used to log into the system, such as a nonexistent user, a user with an incorrect password, a field with no username and password entered,
and an option to enter the correct username and password. When invalid data is used to log in, the test behaves according to the requirements,
meaning that the user cannot log into the system. If the test is executed with the correct input data,
the test will fail because the user is expected to be unable to log into the system.

5. LogoutWithoutLogin "Checking that the logout button is not visible when the user is not logged in"
This test aims to verify that the logout button is not visible to users who are not logged into the system. As required, the button is not visible,
and the test passes successfully.

6. NoLoginUsersPage "Open the first user's profile page without logging into the website"
This test checks whether a user who is not logged into the system can open the profile of a visible user on the homepage. In this attempt,
the system behaves as expected, and an error page is displayed. The test passes.

7. OpenPostAndComment: This test logs in a user, opens the first visible post, and writes a comment.
It then checks if the comment matches the expected comment and if the commenting user matches the username used to log in.
The test passes because everything happens according to the requirements and the elements match.

8. ProfilePosts: This test assumes a user who logs in with several published posts, as well as deleted ones.
The test goes through all visible posts and returns their count, followed by checking if the count matches the number of published posts listed in the user's profile.
The test fails because the count of published posts does not decrease when one is deleted, so the check does not match the expected count. In this case, there is a bug.
