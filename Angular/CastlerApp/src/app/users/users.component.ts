import { Component, Input, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css'],
})
export class UsersComponent implements OnInit {
  constructor(private userService: UserService) {}

  userIds = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  selectedId = 0;
  @Input('data') rcvdData: any;
  getSelectedUser() {
    this.userService.getUser(this.selectedId).subscribe((result: any) => {
      this.rcvdData = result.data;
      console.log(this.rcvdData);
    });
  }

  ngOnInit(): void {
    // this.getSelectedUser();
  }
}
