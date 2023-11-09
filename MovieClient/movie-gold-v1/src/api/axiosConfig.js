/*We can import axios to our project using the below line of code
So we can configure and export the axios objects that we'll use 
to make HTTP requests to the relevant remote API through this code*/

import axios from 'axios';

export default axios.create({

    /*We have the baseURL which provides the base address of the API
    endpoint that our client react application will be calling.
    When we use axios to call an endpoint we won't need to repeat
    the baseURL with each HTTP request within our code. We'll only
    need to include the additional path information required to
    target a specific endpoint
    It will become clear when we will write the code to make a HTTP
    request to the relevant remote endpoint.
    The 'headers' setting is necessary bc during the development phase
    the technology that the remote machine is using to expose the relevant
    API end point is called ngrok.
    we need to include this so our HTTP request are not blocked
    by CORS(Cross-Origin Resource Sharing)*/
    baseURL: 'https://9c96-103-106-239-104.ap.ngrok.io/',
    headers: {"ngrok-skip-browser-warning": "true"}

})