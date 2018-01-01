/**
 * Created by nbfujx on 2017/12/28.
 */


$(function(){
    getJSON("/api/main").catch( error=>{

    }).then( value => {
        //alert(value);
    })
});

