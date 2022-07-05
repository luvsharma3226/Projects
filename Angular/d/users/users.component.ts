import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

interface Food {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {
  selectedUserId = 0;
  temp = 0;
  iter = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];

  constructor(private userService: UserService) {}

  // selectUser() {
  //   this.userService.getUsers(this.selectedUserId).subscribe((result: any) => {
  //     console.log(result);
  //   });
  // }
  ngOnInit(): void {}
}
