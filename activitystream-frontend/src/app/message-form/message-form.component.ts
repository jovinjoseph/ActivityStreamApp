import { Component, OnInit } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';
import { MessagesService } from './../services/messages.service';
import { AuthService } from './../services/auth.service';
import { Router } from '@angular/router';
import { Message } from '../models/Message';
import { MessageService } from '../services/message.service';
import { Circle } from '../models/Circle';

@Component({
  selector: 'app-message-form',
  templateUrl: './message-form.component.html',
  styleUrls: ['./message-form.component.css']
})
export class MessageFormComponent implements OnInit {

  messageId: number;
  senderName: string;
  receiveUser: string;
  receiveCircle: string;
  message: string;
  streamType: string;
  tag: string;

  constructor( private messageServ: MessagesService,
     private router: Router,
     private authServ: AuthService, 
    private messageService: MessageService) {
   }

  ngOnInit() {
  }

  sendToUser() {
    this.messageServ.sendMessageToUser(this.messageId, this.senderName, this.receiveUser, this.message, this.streamType, this.tag);
  }
  sendToCircle() {
    this.messageServ.sendMessageToCircle(this.messageId, this.senderName, this.receiveCircle, this.message, this.streamType, this.tag);
  }

  handleSubmit(event) {
    if(event.keyCode === 13) {
      this.send();
    }
  }
  send(){
    this.senderName = this.authServ.getUsername();
    this.receiveUser = this.messageServ.getReceiveUser();
    this.receiveCircle = this.messageServ.getReceiveCircle();
    if((this.receiveUser ==null ||this.receiveUser ==undefined ||this.receiveUser == "") &&
     ( this.receiveCircle ==null || this.receiveCircle ==undefined ||this.receiveCircle =="")) {
      this.messageService.error("Receive not selected! Please select a user or circle to send your message .");
    } else if((this.receiveUser !=null) && (this.receiveUser !=undefined) &&(this.receiveUser != "")){
      this.messageService.clear();
      this.sendToUser();
    } else {
      this.messageService.clear();
      this.sendToCircle();
    }
  }
}