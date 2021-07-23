import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: 'toolbar.component.html',
  styles: [`:host {
    background-color: #fff;
    color: #004951;
    display: block;
    height: 70px;
    padding: 0 16px;
    font-size: 20px;
    
  }

  h1 {
    font-size: 25px;
    font-weight: normal;
    letter-spacing: 0.1px;
    margin-left: 10px;  
    font-family: Poppins-Medium ;
  }

  .more {
    height: 70px;
    margin-top: 2px;
    width: 140px;
  }`]
})
export class ToolbarComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

}
