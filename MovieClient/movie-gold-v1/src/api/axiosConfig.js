/*We can import axios to our project using the below line of code
So we can configure and export the axios objects that we'll use 
to make HTTP requests to the relevant remote API through this code*/

import axios from 'axios';

export default axios.create({

    
    baseURL: 'https://9c96-103-106-239-104.ap.ngrok.io/',
    headers: {"ngrok-skip-browser-warning": "true"}

})