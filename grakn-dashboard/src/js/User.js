import EngineClient from '../js/EngineClient.js';

export default {

    newSession(creds,fn) {
        EngineClient.newSession(creds, fn);
    },

    setAuthToken(token){
      localStorage.setItem('id_token', token);
    },

    setReasonerStatus(status){
      localStorage.setItem('use_reasoner', status);

    },

    getReasonerStatus(){
      return localStorage.getItem('use_reasoner');
    },

    signup(context, creds, redirect) {
        context.$http.post(SIGNUP_URL, creds, (data) => {
            localStorage.setItem('id_token', data.id_token)

            this.user.authenticated = true

            if (redirect) {
                router.go(redirect)
            }

        }).error((err) => {
            context.error = err
        })
    },

    setCurrentKeySpace(keyspace) {
        localStorage.setItem('current_keyspace', keyspace);
    },

    getCurrentKeySpace() {
        let keyspace = localStorage.getItem('current_keyspace');
        //something better here
        if (keyspace == undefined) {
            this.setCurrentKeySpace('grakn');
            keyspace='grakn';
        }
        return keyspace;
    },

    logout() {
        localStorage.removeItem('id_token')
    },

    isAuthenticated() {
        let jwt = localStorage.getItem('id_token');
        if (jwt) {
            return true;
        } else {
            return false;
        }
    }
}
