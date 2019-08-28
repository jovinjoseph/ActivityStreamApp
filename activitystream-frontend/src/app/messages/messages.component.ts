import { Component, OnInit, Input } from '@angular/core';
import { MessagesService } from '../services/messages.service';
import { AuthService } from '../services/auth.service';
import { Message } from '../models/Message';

@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {

  @Input() chatMessage: Message;
  userName: string;
  messageContent: string;
  timeStamp: Date = new Date();


  constructor(private authService: AuthService) {
    this. userName = authService.getUsername();
  }

  ngOnInit(chatMessage = this.chatMessage) {
    this.messageContent = chatMessage.message;
    this.timeStamp = chatMessage.postedDate;
    this.userName = chatMessage.senderName;
  }
}
