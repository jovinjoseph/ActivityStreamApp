import { Injectable } from "@angular/core";
import { Headers, Http} from "@angular/http";
import { HttpHeaders, HttpClient } from "@angular/common/http";
import { AuthService } from "./auth.service";

@Injectable()
export class ActivityHttpClient{

    constructor(private http: Http,private authsvc:AuthService){}

    createHeader(headers: Headers){
        headers.append('authorization', 'Bearer ' +
      localStorage.getItem("jwt_token"));
      headers.append('Content-Type','application/json');
      headers.append('Accept','application/json' );
      headers.append('username',this.authsvc.getUsername());
    }

    get(url){
       let headers = new Headers();
       this.createHeader(headers);
       return this.http.get(url,{
           headers: headers
         });
        }

    post(url, data){
        let headers = new Headers();
        this.createHeader(headers);
        return this.http.post(url,data,{
                headers: headers
              });
    }   

    put(url, data){
        let headers = new Headers();
        this.createHeader(headers);
        return this.http.put(url,data,{
                headers: headers
              });
    } 

    delete(url){
        let headers = new Headers();
        this.createHeader(headers);
        return this.http.delete(url,{
            headers: headers
          });
         }
}