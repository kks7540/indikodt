var Dns;
    Dns = location.href; // http://localhost:9999/html/contract/provisional/crt0001.html
    Dns = Dns.split("//"); // http:,localhost:9999/html/contract/provisional/crt0001.html
    Dns = Dns[1].substr(0, Dns[1].indexOf("/")); // localhost:9999
    Dns = Dns.substr(0, Dns.indexOf(":")); // localhost
    Dns = "http://" + Dns + ":8080"

function isNull(obj){
	if(obj == null || obj == undefined || obj == "" || obj == "null" || obj == "NULL" || obj == "undefined"){
		return true;
	}
	return false;
}