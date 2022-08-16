package cn.dicraft.myblog.dao;

import cn.dicraft.myblog.entity.Blog;
import cn.dicraft.myblog.queryVo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: DiCraft
 * @Date: 2022-08-14 11:29
 * @package: cn.dicraft.myblog.dao
 * @Version: 1.0
 * @Decsription: 博客管理持久层接口
 */
@Mapper
@Repository
public interface BlogDao {

    /**
     * 保存新增博客
     * @param blog
     * @return
     */
    int saveBlog(Blog blog);

    /**
     * 查询文章管理列表
     * @return
     */
    List<BlogQuery> getAllBlogQuery();

    /**
     * 删除博客
     * @param id
     */
    void deleteBlog(Long id);

    /**
     * 编辑博客
     * @param showBlog
     * @return
     */
    int updateBlog(ShowBlog showBlog);

    /**
     * 查询编辑修改的文章
     * @param id
     * @return
     */
    ShowBlog getBlogById(Long id);

    /**
     * 搜索博客管理列表
     * @param searchBlog
     * @return
     */
    List<BlogQuery> searchByTitleAndType(SearchBlog searchBlog);

    /**
     * 查询首页最新博客列表信息
     * @return
     */
    List<FirstPageBlog> getFirstPageBlog();

    /**
     * 查询首页最新推荐信息
     * @return
     */
    List<RecommendBlog> getAllRecommendBlog();

    /**
     * 搜索博客列表
     * @param query
     * @return
     */
    List<FirstPageBlog> getSearchBlog(String query);

    /**
     * 统计博客总数
     * @return
     */
    Integer getBlogTotal();

    /**
     * 统计访问总数
     * @return
     */
    Integer getBlogViewTotal();

    /**
     * 统计评论总数
     * @return
     */
    Integer getBlogCommentTotal();

    /**
     * 统计留言总数
     * @return
     */
    Integer getBlogMessageTotal();

    /**
     * 查询博客详情
     * @param id
     * @return
     */
    DetailedBlog getDetailedBlog(Long id);

    /**
     * 文章访问更新
     * @param id
     * @return
     */
    int updateViews(Long id);

    /**
     * 根据博客id查询出评论数量
     * @param id
     * @return
     */
    int getCommentCountById(Long id);

    /**
     * 根据TypeId查询博客列表，显示在分类页面
     * @param typeId
     * @return
     */
    List<FirstPageBlog> getByTypeId(Long typeId);

    /**
     * 查询最新评论
     * @return
     */
    List<NewComment> getNewComment();

}
