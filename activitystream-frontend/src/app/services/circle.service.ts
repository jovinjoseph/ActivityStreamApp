import { Injectable } from "@angular/core";
import { Headers, Http, Jsonp } from "@angular/http";
import "rxjs/Rx";
import { Circle } from "../models/Circle";
import { ActivityHttpClient } from "./activityhttpclient.service";
@Injectable()
export class CircleService {

  private serviceUrlCircle = "http://localhost:8084/api/circle";
  private serviceUrlUserCircle ="http://localhost:8085/api/usercircle";
  circles: Circle[];

  constructor(private http: ActivityHttpClient) { }

  //Method to create a new Circle
    createCircle(circleName: string, creatorId: string) {
      const json = JSON.stringify({circleName,creatorId});
      return this.http.post(this.serviceUrlCircle, json).toPromise().catch(this.handleError);
    }

    // MEthod to add a user/sbscribe to a circle
    addUserToCircle(circleName: string, username: string) {
      const json = JSON.stringify({circleName,username});
      const url = this.serviceUrlUserCircle+ '/addToCircle/'+username +'/'+circleName;
      return this.http.put(url, json).toPromise().catch(this.handleError);
    }

    //method to remove user from a circle
    removeUserFromCircle(circleName: string, username: string) {
      const json = JSON.stringify({circleName,username});
      const url = this.serviceUrlUserCircle+ '/removeFromCircle/'+username +'/'+circleName;
      return this.http.put(url, json).toPromise().catch(this.handleError);    
    }

    //Get all circles a particular user part of
    getAllSubscribedCircles(username: string) {
        const url = this.serviceUrlUserCircle + '/searchByUser/'+username;
        return this.http.get(url).toPromise().catch(this.handleError);
    }

    //Get all circles 
    getCircleList(){
      return this.http.get(this.serviceUrlCircle).toPromise().catch(this.handleError); 
    }

    private handleError(error: any) {
    }
}
