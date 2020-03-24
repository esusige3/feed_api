package com.esusige.feed_api.service;

import com.esusige.feed_api.domain.Comment;
import com.esusige.feed_api.repository.FeedRepository;
import com.esusige.feed_api.dto.FeedDetail;
import com.esusige.feed_api.domain.Feed;
import com.esusige.feed_api.domain.Image;
import com.esusige.feed_api.service.interfaces.IFeedCommentService;
import com.esusige.feed_api.service.interfaces.IFeedLikeService;
import com.esusige.feed_api.service.interfaces.IFeedService;
import com.esusige.feed_api.service.interfaces.IFeedShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Service
public class FeedService implements IFeedService {

    @Autowired
    private FeedRepository dao_feed;

    @Autowired
    private IFeedCommentService feedCommentService;

    @Autowired
    private IFeedShareService feedShareService;

    @Autowired
    private IFeedLikeService feedLikeService;



    @Override
    public void GetTest(){
        Feed feedService3 = new Feed("https://s3.ap-northeast-2.amazonaws.com/dcode-prod-bucket//mdInfo/thumb/1542106760-3e82774178a54270.JPG",
                "d.fashion",
                "2020년 가을·겨울 패션위크 무대를\n" +
                "가득 채운 50개의 핸드백들.\n" +
                "　\n" +
                "봄·여름 컬렉션을 통해 여성복 브랜드들이 선보이는 핸드백은 대게 밝은 색상을 사용합니다. 그러나 가을·겨울 컬렉션에서는 보다 중립적인 색상을 보여주는 경우가 많죠. 이번 2020년 가을·겨울 컬렉션도 예외는 아니었습니다.\n" +
                "　\n" +
                "주로 블랙, 화이트, 베이지, 그린 컬러의 핸드백을 만나볼 수 있었으며 펜디, 에르메스, 루이비통, 프라다, 버버리 하우스는 눈이 부실 정도의 옐로 컬러를 사용했고 펜디, 보테가 베네타, 발망, 누메로 벤투노, MSGM 등 그 외 수많은 하우스에서는 프린지, 체인, 오버사이즈 등 비슷한 디자인을 내놓았지만 각기 다른 시즌의 테마를 담아내며 브랜드의 고유한 디자인을 만나볼 수 있었습니다.\n" +
                "　\n" +
                "런던, 밀란, 파리의 2020년 가을·겨울 패션위크 무대를 꾸며낸 50개의 핸드백을 이번 컨텐츠를 통해 모아봤습니다. 올 가을과 겨울에는 어떤 핸드백이 트렌드를 주도하게 될까요?");
        feedService3.addImage(new Image("https://s3.ap-northeast-2.amazonaws.com/dcode-prod-bucket/feeds/handbags/1583831306-81c27d3738e3490f.jpg"));
        feedService3.addImage(new Image("https://s3.ap-northeast-2.amazonaws.com/dcode-prod-bucket/feeds/handbags/1583831306-ef0db4a322fa4387.jpg"));
        feedService3.addImage(new Image("https://s3.ap-northeast-2.amazonaws.com/dcode-prod-bucket/feeds/handbags/1583831306-2f55cf8728c846f2.jpg"));
        this.dao_feed.save(feedService3);



    }



    @Override
    public Page<FeedDetail> ListFeeds(int pageNo, int pageSize) {
        List<Feed> feedList = this.dao_feed.findAll();
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize,Sort.Direction.DESC,"updatedAt");
        Page<Feed> entities = this.dao_feed.findAll(pageRequest);
        Page<FeedDetail> dtoPage = entities.map(new Function<Feed, FeedDetail>() {
            @Override
            public FeedDetail apply(Feed feed) {
                FeedDetail dto;
                dto = new FeedDetail(feed.getId(),feed.getMD_title(),feed.getMD_image(),feed.getImageList(),feed.getText(),
                        null,
                        feed.getCommentCount(),
                        feed.getSharedCount(),
                        feed.getLikeCount());
                return dto;
            }
        });


        /*Page<FeedDetail> dto_feedList = new
        feedList.forEach(feed -> {

            //System.out.println("id: "+comment.getId()+" comment: "+comment.getComment());
            dto_feedList.add(new FeedDetail(feed.getId(),feed.getMD_title(),feed.getMD_image(),feed.getImageList(),feed.getText(),
                    null,
                    this.feedCommentService.CountComment(feed.getId()).getCommentCount(),
                    this.feedShareService.CountShare(feed.getId()).getSharedCount(),
                    this.feedLikeService.CountLike(feed.getId()).getLikeCount(),
                    feed.getUpdated()));
            System.out.println("Feed 처리");
        });

        Pageable pageable = PageRequest.of(pageNo,pageSize, new Sort(Sort.Direction.DESC,""))*/

        return dtoPage;
    }

    @Override
    public FeedDetail GetDetail(Long feedId,Long userId) {
        try{
           Feed feed = this.dao_feed.findById(feedId).orElse(null);
           if(feed != null){

               FeedDetail dto_feed = new FeedDetail(feed.getId(), feed.getMD_title(), feed.getMD_image(), feed.getImageList(),feed.getText(),
                       this.feedLikeService.CheckOwnLike(feedId,userId),
                       feed.getCommentCount(),
                       feed.getSharedCount(),
                       feed.getLikeCount());
               return dto_feed;
           }
           return null;
        }catch (Exception e){
            return null;
        }

    }

    @Override
    public boolean PostFeed(FeedDetail dto_feed) {

        return false;
    }


}
