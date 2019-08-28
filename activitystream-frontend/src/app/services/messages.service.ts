import { Injectable } from "@angular/core";
import { Headers, Http, Jsonp } from "@angular/http";
import "rxjs/Rx";
import { Subject } from 'rxjs/Subject';
import { Observable } from 'rxjs/Observable';
import { Message } from "../models/Message";
import { ActivityHttpClient } from "./activityhttpclient.service";
import { BehaviorSubject } from "rxjs/BehaviorSubject";
import { AuthService } from "./auth.service";
import { send } from "q";
@Injectable()
export class MessagesService {
	
private serviceUrl = "http://localhost:8086/api/message/";
messages: Array<Message>;
senderName: string;
receiveUser: string;
receiveCircle: string;

private messagesSubject: BehaviorSubject<Array<Message>>;

constructor(private http: ActivityHttpClient, private authService: AuthService) {
  this.messages =[];
  this.messagesSubject = new BehaviorSubject(this.messages);
}

//Method to send messages to a user
  sendMessageToUser(messageId: number,senderName: string, receiverId: string,message: string,
      streamType: string,tag: string) {
    const url = this.serviceUrl + 'sendMessageToUser/'+receiverId;
    const json = JSON.stringify({messageId,senderName,receiverId,message,
      streamType,tag});

    return this.http.post(url, json).subscribe(res => { this.getUserMessages(receiverId);}, error => {this.handleError});
      
  }

  //Method to send messages to a circle
  sendMessageToCircle(messageId: number,senderName: string, circleName: string,message: string,
      streamType: string,tag: string) {
    const url = this.serviceUrl + 'sendMessageToCircle/'+circleName;
    const json = JSON.stringify({messageId,senderName,circleName,message,
      streamType,tag});
    return this.http.post(url, json).subscribe(res =>
       { this.getCircleMessages(circleName);},
        error => {this.handleError});
  }
  public getMessageSubject(): Observable<Array<Message>> {
      return this.messagesSubject.asObservable();
  }

 //Method to get messages sent to and received from a user
  getUserMessages(username:string){
    this.senderName = this.authService.getUsername();
    this.receiveUser = username;
    this.receiveCircle = "";
    const url = this.serviceUrl + 'getMessagesByUser/'+this.senderName+'/'+this.receiveUser+'/'+1;
    this.getMessageList(url);

  }

  //Method to get messages send to a circle
  getCircleMessages(circlename:string){
    this.receiveCircle = circlename;
    this.receiveUser = "";
    const url = this.serviceUrl + 'getMessagesByCircle/'+this.receiveCircle+'/'+1;
    this.getMessageList(url);

  }

  getMessageList(url:string) {
    return this.http.get(url).subscribe(res => {
      this.messages = res.json();
    });
  }	

	private handleError(error: any) {
  }
  
  setReceiveUser(username: string){
    this.receiveUser = username;
  }
  setReceiveCircle(circleName: string){
    this.receiveCircle = circleName;
  }
  getReceiveUser(){
    return this.receiveUser;
  }
  getReceiveCircle(){
    return this.receiveCircle ;
  }
}