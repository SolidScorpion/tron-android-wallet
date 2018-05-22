package com.devband.tronwalletforandroid.ui.vote.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VoteItem {

    private int no;

    private String address;

    private String url;

    private Long totalVoteCount;

    private Long voteCount;

    private Long myVoteCount;
}