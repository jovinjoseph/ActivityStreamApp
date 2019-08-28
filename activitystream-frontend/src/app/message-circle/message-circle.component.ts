import { Component, OnInit, Input } from '@angular/core';
import { Circle } from '../models/Circle';
import { CircleService } from '../services/circle.service';
import { Router } from '@angular/router';
import { MessagesService } from '../services/messages.service';
import { MessageService } from '../services/message.service';

@Component({
  selector: 'app-message-circle',
  templateUrl: './message-circle.component.html',
  styleUrls: ['./message-circle.component.css']
})
export class MessageCircleComponent implements OnInit {

 @Input() messageCircle: string;
  circleName :string;

  constructor(private router: Router, private messagesService: MessagesService, private messageService: MessageService) {  }

  ngOnInit(messageCircle = this.messageCircle) {
    this.circleName = messageCircle;
  }
  goToMessage(circlename: string){
    this.messageService.clear();
    this.messagesService.getCircleMessages(circlename);
  }
}
