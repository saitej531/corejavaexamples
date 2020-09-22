import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl:'app.component.html',
  styleUrls: ['app.component.css']
})
export class AppComponent {
  title = 'My firstapp';
  description="My first angular application";
  startDate="09-09-2020";
  name="firstapp";

  constructor(private router:Router){
   
    //programtic way of navigating to a path
   // router.navigate(['user-list']);
  }

}
