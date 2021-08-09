import { Component, Input, OnInit } from '@angular/core';
import { Portafolio } from 'src/app/Models/Portafolio';
import { TwitterService } from 'src/app/Services/twitter-service.service';

@Component({
  selector: 'app-tweets',
  templateUrl: './tweets.component.html',
  styleUrls: ['./tweets.component.css']
})
export class TweetsComponent implements OnInit {

  tweets: any[] = [];

  @Input() portafolio!: string;

  @Input('data') data!: string;

  constructor(private service: TwitterService) {
  }

  ngOnInit(): void {
    this.service.getRecentTweets().subscribe(response => {
      if(response != null && response.length > 0){
        this.tweets = response;
      }
    });
  }

}
