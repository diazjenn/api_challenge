# api_challenge

CODE2040 

Tech Assessment for the CODE2040 2017 Fellows application.

Step I: Registration

To get started, you’re first going to connect to the registration endpoint. It lives here:

http://challenge.code2040.org/api/register

The registration endpoint expects a JSON dictionary with two keys, token and github. This JSON should be sent in the body of your HTTP request.

For token, pass in a string with the token you see above. For github, pass in the URL of the repository you created in the last step.

Hint: HTTP has a few types of “methods.” The registration endpoint is going to be expecting you to use POST to send your JSON.
