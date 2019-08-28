import { Component, OnInit, OnChanges } from '@angular/core';
import { MessageService } from './../services/message.service';
@Component({
  selector: 'app-message',
  templateUrl: './message.component.html',
  styleUrls: ['./message.component.css']
})
export class MessageComponent implements OnInit, OnChanges {
  public message: any;
  constructor(private messageService: MessageService) {}
  public ngOnInit() {
    this.messageService.getMessage().subscribe(message => {
      this.message = message;
    });
  }
  public ngOnChanges() {
    this.messageService.getMessage().subscribe(message => {
      this.message = message;
    });
  }
}