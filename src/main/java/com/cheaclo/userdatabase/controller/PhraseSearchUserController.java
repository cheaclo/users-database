package com.cheaclo.userdatabase.controller;

import com.cheaclo.userdatabase.entity.User;
import com.cheaclo.userdatabase.entity.UserSearchPhrase;
import com.cheaclo.userdatabase.model.request.AddPhraseRequestBody;
import com.cheaclo.userdatabase.repository.UserRepository;
import com.cheaclo.userdatabase.repository.UserSearchPhraseRepository;
import com.cheaclo.userdatabase.service.response.PhraseSearchUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user/phrase")
public class PhraseSearchUserController {
    private static final int NUMBER_OF_PHRASES_PER_USER = 100;

    private UserRepository userRepository;
    private UserSearchPhraseRepository userSearchPhraseRepository;
    private PhraseSearchUserResponse phraseSearchUserResponse;

    @PostMapping("/add")
    public ResponseEntity<PhraseSearchUserResponse> addPhrase(@Valid @RequestBody AddPhraseRequestBody request) {
        User user = userRepository.findFirstById(request.getUserId());
        if (user == null)
            return ResponseEntity.ok(phraseSearchUserResponse.userNotFound());

        List<UserSearchPhrase> searches = userSearchPhraseRepository.findAllByUserOrderBySearchDate(user);
        if (searches.size() >= NUMBER_OF_PHRASES_PER_USER)
            userSearchPhraseRepository.delete(searches.get(0));

        userSearchPhraseRepository.save(new UserSearchPhrase(-1L, new Date(), user, request.getSearchedPhrase()));
        return ResponseEntity.ok(phraseSearchUserResponse.success());
    }
}
